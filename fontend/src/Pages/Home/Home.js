import styles from './Home.module.scss';
import classNames from 'classnames/bind';

const cx = classNames.bind(styles);

// Sample food products data
const foodProducts = [
  {
    id: 1,
    name: "Bò nướng tảng",
    description: "Món bò nướng nguyên tảng, đậm đà, mềm ngọt",
    price: "150000",
    image: "https://images.unsplash.com/photo-1546833999-b9f581a1996d?w=400&h=300&fit=crop"
  },
  {
    id: 2,
    name: "Cơm cuộn rong biển",
    description: "Món cơm cuộn kiểu Hàn, cuốn với rau và trứng",
    price: "80000",
    image: "https://images.unsplash.com/photo-1579584425555-c3ce17fd4351?w=400&h=300&fit=crop"
  },
  {
    id: 3,
    name: "Cà ri bò Nhật",
    description: "Cà ri thơm béo kiểu Nhật Bản, thịt bò hầm mềm",
    price: "130000",
    image: "https://images.unsplash.com/photo-1546833999-b9f581a1996d?w=400&h=300&fit=crop"
  }
];

function Home() {
  const handleAddToCart = (productId) => {
    console.log(`Added product ${productId} to cart`);
    // Add to cart logic here
  };

  const formatPrice = (price) => {
    return new Intl.NumberFormat('vi-VN').format(price) + ' VND';
  };

  return (
    <div className={cx('home')}>
      <div className={cx('container')}>
        <h1 className={cx('title')}>Món ăn nổi bật</h1>
        <div className={cx('products-grid')}>
          {foodProducts.map((product) => (
            <div key={product.id} className={cx('product-card')}>
              <div className={cx('product-image')}>
                <img src={product.image} alt={product.name} />
              </div>
              <div className={cx('product-info')}>
                <h3 className={cx('product-name')}>{product.name}</h3>
                <p className={cx('product-description')}>{product.description}</p>
                <div className={cx('product-price')}>{formatPrice(product.price)}</div>
                <button 
                  className={cx('add-to-cart-btn')}
                  onClick={() => handleAddToCart(product.id)}
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

export default Home;