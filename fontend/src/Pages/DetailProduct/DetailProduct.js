import styles from './DetailProduct.module.scss';
import classNames from 'classnames/bind';
import { useState, useEffect } from 'react';
import React from 'react';
import { useParams } from 'react-router-dom';

const cx = classNames.bind(styles);

const token = localStorage.getItem('token');

function DetailProduct() {
  const { id } = useParams(); // lấy id từ URL
  const [product, setProduct] = useState(null);

  const handleAddToCart = ({ idProduct, quantity }) => {
    fetch(`http://localhost:8080/identity/cartItems`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      },
      body: JSON.stringify({
        cartId: "3",
        productId: idProduct,
        quantity: quantity
      }),
    })
      .then(res => res.json())
      .then(data => {
        if (data.code === 1000) {
          alert('Thêm vào giỏ hàng thành công!');
        } else {
          alert('Thêm vào giỏ hàng thất bại!');
        }
      })
      .catch(err => {
        console.error(err);
        alert('Đã xảy ra lỗi khi thêm vào giỏ hàng!');
      });

  }

  useEffect(() => {
    fetch(`http://localhost:8080/identity/products/${id}`) // API chi tiết
      .then(res => res.json())
      .then(data => {
        // Nếu API của bạn trả { code, result }
        if (data.code === 1000) {
          setProduct(data.result);
        }
      })
      .catch(err => console.error(err));
  }, [id]);

  if (!product) return <p>Đang tải sản phẩm...</p>;

  return (
    <div className={cx('container')}>
      <div className={cx('card')}>
        <div className={cx('layout')}>
          <div className={cx('imageWrap')}>
            <img src={product.image || "/no-image.png"} alt={product.name} />
          </div>
          <div className={cx('info')}>
            <h1 className={cx('name')}>{product.name}</h1>
            <div className={cx('price')}>{product.price.toLocaleString("vi-VN")} VND</div>
            <div className={cx('stock')}>Tồn kho: {product.stock}</div>
            <div className={cx('divider')} />
            <div className={cx('description')}>{product.description}</div>
            <div className={cx('divider')} />
            <div className={cx('metaRow')}>
              <div className={cx('label')}>Mã sản phẩm</div>
              <div className={cx('value')}>{product.id || id}</div>
            </div>
            <div className={cx('actions')}>
              <button
                className={cx('button', 'primary')}
                onClick={() => handleAddToCart({ idProduct: product.id || id, quantity: 1 })}
              >
                Thêm vào giỏ
              </button>
              <button className={cx('button', 'secondary')}>Mua ngay</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default DetailProduct;


