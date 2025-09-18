import styles from './Login.module.scss';
import classNames from 'classnames/bind';
import { useState, useEffect } from 'react';
import React from 'react';
import { Link } from 'react-router-dom';
const cx = classNames.bind(styles);

function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(false);

    const handleSubmit = (e) => {
        e.preventDefault();
        try {
            fetch('http://localhost:8080/identity/auth/token', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    username,
                    password
                })
            })
                .then(async res => {
                    const data = await res.json(); // đọc JSON dù thành công hay lỗi
                    if (!res.ok) {
                        // Nếu status != 200 thì ném ra lỗi kèm thông tin JSON
                        throw new Error(data.message || "Login failed");
                    }
                    return data;
                })
                .then(data => {
                    console.log("Login success:", data);
                    localStorage.setItem("token", data.result.token);
                    window.location.href = '/';
                })
                .catch(err => {
                    // Lỗi sẽ được show ra ở đây
                    console.error("Error:", err.message);
                    alert("Đăng nhập thất bại: " + err.message);
                });

        } catch (error) {
            console.error('Error during login:', error);
            setError('Đã xảy ra lỗi trong quá trình đăng nhập. Vui lòng thử lại.');
        }
    };




    return (
        <div className={cx('login-container')}>
            <h2 className={cx('login-title')}>Đăng nhập</h2>
            <form className={cx('login-form')} onSubmit={handleSubmit} >

                <input type='text' placceholder='Tên đăng nhập'
                    value={username}
                    onChange={(e) => setUsername(e.target.value)} />
                <input type='password' placeholder='Mật khẩu'
                    value={password}
                    onChange={e => setPassword(e.target.value)} />

                <button type='submit' className={cx('login-button')} >Đăng nhập</button>
                <p className={cx('signup-link')}>Chưa có tài khoản? <Link to="/signin">Đăng ký</Link></p>
            </form>

        </div>
    )
}

export default Login;


