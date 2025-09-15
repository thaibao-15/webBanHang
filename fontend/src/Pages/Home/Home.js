import styles from './Home.module.scss';
import classNames from 'classnames/bind';
import { useState, useEffect } from 'react';
import React from 'react';

const cx = classNames.bind(styles);

// Sample food products data

function FetchProducts() {
  const [products, setProducts] = useState([])
  const [loading, setLoading] = useState(false)
  useEffect(
    () => {
      fetch('https://fakestoreapi.com/products')
        .then(response => response.json())
        .then(response => {
          setProducts(response)
          setLoading(true)
        })
        .catch(error => console.log('error', error))

    }
    , [])
  return (
    <div className={cx('home')}>
      <div className={cx('container')}>
        <h1 className={cx('title')}>Món ăn nổi bật</h1>
        
        <div className={cx('products-grid')}>
        {!loading && <p>Loading...</p>}

          {products.map((product) => (
            <div key={product.id} className={cx('product-card')}>
              <div className={cx('product-image')}>
                <img src={product.image} alt={product.title} />
              </div>
              <div className={cx('product-info')}>
                <h3 className={cx('product-name')}>{product.title}</h3>
                <p className={cx('product-description')}>{product.description}</p>
                <div className={cx('product-price')}>{(product.price)}</div>
                <button
                  className={cx('add-to-cart-btn')}

                >
                  Thêm vào giỏ
                </button>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>

  );

}

function Home() {
  const handleAddToCart = (productId) => {
    console.log(`Added product ${productId} to cart`);
    // Add to cart logic here
  };

  const formatPrice = (price) => {
    return new Intl.NumberFormat('vi-VN').format(price) + ' VND';
  };

  return (
    <FetchProducts />);
}

export default Home;