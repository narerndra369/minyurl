export const styles = {
    page: {
        minHeight: '100vh',
        backgroundColor: '#0f172a',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        padding: '20px',
        fontFamily: 'system-ui, -apple-system, sans-serif',
        color: '#e2e8f0'
    },
    container: {
        width: '100%',
        maxWidth: '700px'
    },
    header: {
        textAlign: 'center',
        marginBottom: '30px'
    },
    logo: {
        fontSize: '3rem',
        margin: '0',
        fontWeight: 'bold',
        color: '#3b82f6'
    },
    subtitle: {
        fontSize: '1.1rem',
        color: '#94a3b8',
        marginTop: '10px'
    },
    card: {
        backgroundColor: '#1e293b',
        padding: '40px',
        borderRadius: '16px',
        boxShadow: '0 10px 30px rgba(0,0,0,0.3)',
        marginBottom: '30px',
        border: '1px solid #334155'
    },
    form: {
        display: 'flex',
        flexDirection: 'column',
        gap: '20px'
    },
    inputGroup: {
        display: 'flex',
        flexDirection: 'column',
        flex: 1,
        gap: '8px'
    },
    label: {
        fontSize: '0.9rem',
        fontWeight: '600',
        color: '#cbd5e1'
    },
    input: {
        padding: '12px 16px',
        borderRadius: '8px',
        border: '1px solid #475569',
        backgroundColor: '#0f172a',
        color: '#e2e8f0',
        fontSize: '1rem',
        outline: 'none',
        transition: 'border 0.2s',
        boxSizing: 'border-box'
    },
    row: {
        display: 'flex',
        gap: '20px'
    },
    button: {
        padding: '14px 20px',
        backgroundColor: '#3b82f6',
        color: '#ffffff',
        border: 'none',
        borderRadius: '8px',
        fontSize: '1.1rem',
        fontWeight: 'bold',
        cursor: 'pointer',
        transition: 'background 0.2s',
        textAlign: 'center',
        textDecoration: 'none',
        display: 'inline-block'
    },
    error: {
        marginTop: '20px',
        padding: '12px',
        backgroundColor: '#450a0a',
        border: '1px solid #dc2626',
        color: '#fca5a5',
        borderRadius: '8px',
        textAlign: 'center',
        fontWeight: '500'
    },
    result: {
        marginTop: '20px',
        padding: '15px',
        backgroundColor: '#052e16',
        borderRadius: '8px',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'space-between',
        border: '1px solid #16a34a'
    },
    shortUrl: {
        color: '#4ade80',
        fontWeight: 'bold',
        fontSize: '1rem',
        wordBreak: 'break-all'
    },
    copyButton: {
        backgroundColor: '#16a34a',
        color: 'white',
        border: 'none',
        padding: '8px 16px',
        borderRadius: '6px',
        cursor: 'pointer',
        fontWeight: 'bold',
        marginLeft: '15px',
        whiteSpace: 'nowrap'
    },
    about: {
        backgroundColor: '#1e293b',
        padding: '30px',
        borderRadius: '16px',
        boxShadow: '0 4px 6px rgba(0,0,0,0.1)',
        border: '1px solid #334155'
    },
    aboutTitle: {
        color: '#e2e8f0',
        marginBottom: '15px'
    },
    aboutText: {
        color: '#94a3b8',
        lineHeight: '1.6',
        marginBottom: '15px'
    },
    aboutList: {
        listStyle: 'none',
        padding: '0',
        margin: '0',
        display: 'grid',
        gridTemplateColumns: '1fr 1fr',
        gap: '10px',
        color: '#cbd5e1'
    },
    notFoundContainer: {
        backgroundColor: '#1e293b',
        padding: '50px',
        borderRadius: '16px',
        boxShadow: '0 10px 25px rgba(0,0,0,0.3)',
        textAlign: 'center',
        maxWidth: '500px',
        width: '100%',
        border: '1px solid #334155'
    },
    errorCode: {
        fontSize: '6rem',
        fontWeight: 'bold',
        color: '#dc2626',
        margin: '0',
        lineHeight: '1'
    },
    notFoundTitle: {
        color: '#e2e8f0',
        margin: '10px 0'
    },
    notFoundText: {
        color: '#94a3b8',
        marginBottom: '30px'
    }
};