export default class App {
    constructor(selector) {
        this.appElement = document.querySelector(selector);
        this.components = {};
        console.log('App instantiated.');
    }

    addComponent(component) {
        this.components[component.name] = component;
    }

    showComponent(name) {
        this.currentComponent = this.components[name];
        this.updateView();
    }

    updateView() {
        if(this.currentComponent) {
            this.appElement.innerHTML = '';
            this.appElement.appendChild(document.createElement(this.currentComponent.name));
        }
    }
}