import styles from './Header.module.scss';
import classNames from 'classnames/bind';
import { Link } from 'react-router-dom';

const cx = classNames.bind(styles);

function Header() {
    const handleCartClick = () => {
        console.log('Cart clicked');
        // Navigate to cart page or open cart modal
    };

    return (
        <header className={cx('wrapper')}>
            {/* Logo */}
            <Link to="/" className={cx('logo')}>
                WebBanHang
            </Link>

            {/* Navigation */}
            <nav className={cx('nav')}>
                <ul className={cx('nav-list')}>
                    <li className={cx('nav-item')}>
                        <Link to="/">Trang chủ</Link>
                    </li>
                    <li className={cx('nav-item')}>
                        <Link to="/following">Theo dõi</Link>
                    </li>
                    <li className={cx('nav-item')}>
                        <Link to="/profile">Hồ sơ</Link>
                    </li>
                </ul>
            </nav>

            {/* User Actions */}
            <div className={cx('user-actions')}>
                {/* Search Box */}
                <div className={cx('search-box')}>
                    <span className={cx('search-icon')}>🔍</span>
                    <input type="text" placeholder="Tìm kiếm..." />
                </div>

                {/* User Menu */}
                <div className={cx('user-menu')}>
                    {/* Shopping Cart */}
                    <div className={cx('cart-icon')} onClick={handleCartClick}>
                        🛒
                        <span className={cx('badge')}>2</span>
                    </div>

                    {/* Notification Icon */}
                    <div className={cx('notification-icon')}>
                        🔔
                        <span className={cx('badge')}>3</span>
                    </div>

                    {/* User Avatar */}
                    <div className={cx('avatar')}>
                        U
                    </div>
                </div>
            </div>
        </header>
    );
}

export default Header;