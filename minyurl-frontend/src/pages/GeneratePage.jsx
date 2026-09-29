import React, { useState } from 'react';
import { styles } from '../styles';

const GeneratePage = () => {
    const [longUrl, setLongUrl] = useState('');
    const [expireAt, setExpireAt] = useState('');
    const [custom, setCustom] = useState('');
    const [shortUrl, setShortUrl] = useState('');
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(false);
    const [copied, setCopied] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);
        setError('');
        setShortUrl('');
        setCopied(false);

        try {
            const response = await fetch('http://localhost:9000/generate/shortcode', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({
                    longUrl,
                    expireAt: expireAt || null,
                    custom: custom || null
                })
            });

            const data = await response.json();

            if (response.status === 201) {
                setShortUrl(data.shortUrl);
            } else if (response.status === 409) {
                setError(data.errorResponse || 'Alias already exists.');
            } else {
                setError('An error occurred. Please try again.');
            }
        } catch (err) {
            setError('Network error. Please check your connection.');
        }
        setLoading(false);
    };

    const handleCopy = () => {
        navigator.clipboard.writeText(shortUrl);
        setCopied(true);
        setTimeout(() => setCopied(false), 2000);
    };

    return (
        <>
            <style>{`
                .minyurl-btn:hover { background-color: #2563eb !important; }
                .minyurl-copy:hover { background-color: #15803d !important; }
                .minyurl-input:focus { border-color: #3b82f6 !important; }
                .minyurl-input::placeholder { color: #64748b; }
                @media (max-width: 600px) {
                    .minyurl-row { flex-direction: column !important; gap: 20px !important; }
                    .minyurl-about-list { grid-template-columns: 1fr !important; }
                }
            `}</style>
            <div style={styles.page}>
                <div style={styles.container}>
                    <header style={styles.header}>
                        <h1 style={styles.logo}>🔗 Minyurl</h1>
                        <p style={styles.subtitle}>Shorten your long URLs into clean, manageable links instantly.</p>
                    </header>

                    <div style={styles.card}>
                        <form onSubmit={handleSubmit} style={styles.form}>
                            <div style={styles.inputGroup}>
                                <label style={styles.label}>Long URL</label>
                                <input
                                    style={styles.input}
                                    className="minyurl-input"
                                    type="url"
                                    value={longUrl}
                                    onChange={(e) => setLongUrl(e.target.value)}
                                    placeholder="https://example.com/very/long/url"
                                    required
                                />
                            </div>

                            <div style={styles.row} className="minyurl-row">
                                <div style={styles.inputGroup}>
                                    <label style={styles.label}>Expires At (Optional)</label>
                                    <input
                                        style={styles.input}
                                        className="minyurl-input"
                                        type="datetime-local"
                                        value={expireAt}
                                        onChange={(e) => setExpireAt(e.target.value)}
                                    />
                                </div>
                                <div style={styles.inputGroup}>
                                    <label style={styles.label}>Custom URL (Optional)</label>
                                    <input
                                        style={styles.input}
                                        className="minyurl-input"
                                        type="text"
                                        value={custom}
                                        onChange={(e) => setCustom(e.target.value)}
                                        placeholder="my-custom-link"
                                    />
                                </div>
                            </div>

                            <button type="submit" style={styles.button} className="minyurl-btn" disabled={loading}>
                                {loading ? 'Shortening...' : 'Shorten URL'}
                            </button>
                        </form>

                        {error && <div style={styles.error}>{error}</div>}

                        {shortUrl && (
                            <div style={styles.result}>
                                <span style={styles.shortUrl}>{shortUrl}</span>
                                <button onClick={handleCopy} style={styles.copyButton} className="minyurl-copy">
                                    {copied ? '✓ Copied!' : '📋 Copy'}
                                </button>
                            </div>
                        )}
                    </div>

                    <section style={styles.about}>
                        <h2 style={styles.aboutTitle}>About Minyurl</h2>
                        <p style={styles.aboutText}>
                            Minyurl is a fast, reliable, and completely free URL shortening service. Whether you're sharing links on social media, sending them in emails, or using them in SMS, Minyurl makes your links look professional and neat.
                        </p>
                        <ul style={styles.aboutList} className="minyurl-about-list">
                            <li>🚀 Lightning fast redirection</li>
                            <li>✨ Custom aliases for branded links</li>
                            <li>⏳ Set expiration dates for temporary links</li>
                            <li>📊 Clean and simple interface</li>
                        </ul>
                    </section>
                </div>
            </div>
        </>
    );
};

export default GeneratePage;