import Header from '~/Layouts/Components/Header';
import Sidebar from '~/Layouts/Components/Sidebar';

function DefaultLayout({ children }) {
    return (
        <div>
            <Header />
            <div className="container">
                <Sidebar />
                <div className="content">{children}</div>
            </div>
        </div>
    );

}
export default DefaultLayout;