import styles from './Login.module.css';
import classNames from 'classnames/bind';
import { useState , useEffect} from 'react';
import React from 'react';
import { Link } from 'react-router-dom';
const cx = classNames.bind(styles);

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
    const [loading, setLoading] = useState(false);
    

    return(
    <div className={cx('login-container')}>
        <h2 className={cx('login-title')}>Đăng nhập</h2>

    </div>
    )
}

export default Login;


