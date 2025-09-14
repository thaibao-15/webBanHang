import Home from '~/Pages/Home';
import Following from '~/Pages/Following';
import Profile from '~/Pages/Profile';
import Upload from '~/Pages/Upload';
import Header from '~/Layouts/Components/Header';

//không cần login
const publicRoutes = [
    { path: '/', component: Home },
    { path: 'following', component: Following },
    { path: 'profile', component: Profile, layout: null },
    {path: 'upload', component: Upload, layout: Header}

    // layout null để không sử dụng layout mặc định,

]

//cần login
const privateRoutes = []

export { publicRoutes, privateRoutes }