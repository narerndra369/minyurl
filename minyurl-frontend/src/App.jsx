import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import GeneratePage from './pages/GeneratePage';
import NotFoundPage from './pages/NotFoundPage';

export default function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<GeneratePage />} />
                {/* The backend will redirect here if the short url doesn't exist */}
                <Route path="/404" element={<NotFoundPage />} />
                {/* This catches any invalid routes typed directly in the frontend */}
                <Route path="*" element={<NotFoundPage />} />
            </Routes>
        </Router>
    );
}