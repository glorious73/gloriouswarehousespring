export default class Router {
    constructor(app) {
        this.app    = app;
        this.routes = [];
        this.hashChange = this.hashChange.bind(this); // to ensure hash change is always the one for router
        window.addEventListener("hashchange", this.hashChange);
        window.addEventListener("DOMContentLoaded", this.hashChange);
    }

    addRoute(name, path) {
        this.routes.push({
            name,
            path
        });
    }

    hashChange() {
        const { hash } = window.location;
        const route = this.routes.find(route => {
            return hash.match(new RegExp(route.path));
        });
        if(route) {
            this.app.showComponent(route.name);
            document.body.scrollTop = 0; // Safari
            document.documentElement.scrollTop = 0; // Chrome, Firefox, IE and Opera
            document.querySelector(`app-navbar`).changeActiveElement();
        }
    }
}