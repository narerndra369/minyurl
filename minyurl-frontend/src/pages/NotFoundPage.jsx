import React from 'react';
import { Link } from 'react-router-dom';
import { styles } from '../styles';

const NotFoundPage = () => {
    return (
        <div style={styles.page}>
            <div style={styles.notFoundContainer}>
                <h1 style={styles.logo}>🔗 Minyurl</h1>
                <div style={styles.errorCode}>404</div>
                <h2 style={styles.notFoundTitle}>URL Not Found</h2>
                <p style={styles.notFoundText}>Oops! The short URL you are trying to access does not exist in our system.</p>
                <Link to="/" style={styles.button} className="minyurl-btn">Visit Minyurl Generate Page</Link>
            </div>
        </div>
    );
};

export default NotFoundPage;