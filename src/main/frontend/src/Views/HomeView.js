const template = document.createElement('template');

const utils = /*css*/`
* {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}
.text-center {
    text-align: center;
}
.text-gray {
    color: var(--gray);
}
.py-3 {
    padding-top: 3rem;
    padding-bottom: 3rem;
}
`;

const styles = /*css*/`

/* Tablet Devices */
@media only screen and (max-width: 768px) {
    
  }
  /* /Tablet Devices */
  
  /* Mobile Devices */
  @media only screen and (max-width: 576px) {
    
  }
  /* /Mobile Devices */
`;

template.innerHTML = /*html*/`
<style>
    ${utils}
    ${styles}
</style>
<div class="py-3">
  <h2>Hello World!</h2>
</div>
`;

export default class HomeView extends HTMLElement {
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

window.customElements.define('home-view', HomeView);