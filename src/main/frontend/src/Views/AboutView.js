const template = /*html*/`

`;

const styles = /*css*/`

`;

template.innerHTML = /*html*/`
<style>
    ${styles}
</style>
<div class="">
  <h2>Glorious Warehouse</h2>
</div>
`;

export default class AboutView extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({ mode: 'open' });
        this.shadowRoot.appendChild(template.content.cloneNode(true));
        this.assignElements();
    }

    connectedCallback() {

    }

    disconnectedCallback() {

    }

    assignElements() {

    }
}

window.customElements.define('about-view', AboutView);