// App & Router
import App from './app';
import Router from './Router/Router';
// Views
import HomeView from './Views/HomeView';

// Components (must be imported)
import NavComponent from './Component/NavComponent';

const app = new App("#app");
const router = new Router(app);

// Add Views
app.addComponent({
    name: 'home-view',
    view: HomeView
});
app.addComponent({
    name: 'about-view',
    view: AboutView
});

// Add routes
router.addRoute('home-view', "^$");
router.addRoute('home-view', "^#/$");
router.addRoute('about-view', "^#/about$");