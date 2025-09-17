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
                .then(res => {
                    if (!res.ok) {
                        throw new Error("Network response was not ok: " + res.status);
                    }
                    return res.json();
                })
                .then(data => {
                    console.log("Response data:", data); // log thử để debug
                    if (data.code === 1000) {
                        alert('Đăng nhập thành công!');
                    } else {
                        alert('Đăng nhập thất bại!');
                    }
                })
                .catch(err => {
                    console.error(err);
                    alert('Đã xảy ra lỗi khi đăng nhập!');
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


