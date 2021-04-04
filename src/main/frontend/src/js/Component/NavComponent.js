const template = document.createElement('template');

const styles = /*css*/`
  header {
    margin-bottom: 70px;
  }
  
  .nav {
    width: 100%;
    background-color: var(--white);
    border-bottom: 1px var(--whiteborder) solid;
    display: flex;
    justify-content: space-between;
    align-items: center;
    position: fixed;
    top: 0;
    left: 0;
    height: 70px;
    z-index: 99;
    transition: top 0.2s ease-in;
  }
  /* .nav-box-shadow {
    box-shadow: 0 0.25rem 0.75rem rgba(0, 0, 0, 0.05);
  } */
  
  .nav > .nav-header {
    display: inline;
  }
  .nav > .nav-header > .nav-title {
    display: inline-block;
    font-size: 22px;
    color: var(--gray);
    padding: 10px 10px 10px 10px;
    cursor: pointer;
  }
  .navbar-brand-img {
    width: auto;
    height: 65px; /* Adjust to fit your logo */
    margin: -0.2rem auto auto 2.5rem;
    background-repeat: no-repeat;
  }
  
  /*-- Nav Items --*/
  .nav > .nav-items {
    display: inline-block;
    float: right;
    font-size: 18px;
    margin-right: 2rem;
  }
  .nav > .nav-items > a,
  .nav > .nav-items > label {
    display: inline-block;
    padding: 10px 20px 10px 20px;
    text-decoration: none;
    color: var(--lightgray);
    font-weight: bold;
    cursor: pointer;
    transition: all 0.2s ease-in;
  }
  .nav > .nav-items > a.active,
  .nav-items > label.active {
    color: var(--gray);
    background-color: var(--lightwhite);
    border: 0.5px solid var(--grayborder);
    border-radius: 1.25rem;
  }
  .nav > .nav-items > a:hover,
  .nav-items > label:hover {
    background-color: var(--lightwhite);
    color: var(--gray);
    border-radius: 1.25rem;
  }
  /*-- /Nav Items --*/
  
  /*-- Nav dropdown --*/
  input#nav-dropdown {
    display: none;
  }
  input#nav-dropdown ~ label {
    position: relative;
    font-weight: bold; /* Signify it is a dropdown */
  }
  input#nav-dropdown ~ ul {
    position: absolute;
    top: 50px; /* Trial and error */
    right: 50px; /* Hard coded. Can be calc.ed with JS or done separately for each ul element. */
    padding: 0.5rem 1.5rem;
    background-color: var(--white);
    border: 1px solid #ddd;
  }
  input#nav-dropdown ~ ul > li {
    display: block;
    list-style-type: none;
    background-color: var(--white);
    padding: 0.5rem;
    text-align: center;
  }
  input#nav-dropdown ~ ul > li > a {
    color: var(--gray);
    text-decoration: none;
  }
  input#nav-dropdown ~ ul > li:hover {
    background-color: #f2f2f2;
    border-radius: 0.3rem;
  }
  input#nav-dropdown:not(:checked) ~ ul {
    display: none;
  }
  input#nav-dropdown:checked ~ ul {
    display: block;
  }
  /*-- /Nav dropdown --*/
  
  /*-- Responsive --*/
  .nav > .nav-btn {
    display: none;
  }
  .nav > #nav-check {
    display: none;
  }
  /*-- /Responsive --*/
  
  /*----- Media Query for mobile and tablet devices -----*/
  @media only screen and (max-width: 992px) {
    /* Width covers entire screen */
  
    /* /Width Covers Entire Screen */
    /* Navbar Brand */
    .navbar-brand-img {
      margin: -0.2rem auto auto 0.8rem;
      background-repeat: no-repeat;
    }
    /* /Navbar Brand */
    /* Navbar Toggle */
    .nav > .nav-btn {
      height: 70px;
      display: inline-block;
      position: absolute;
      right: 0px;
      top: 0px;
      padding-top: 20px;
      padding-right: 20px;
    }
    .nav > .nav-btn > label {
      display: inline-block;
      width: 100%;
      height: auto;
      font-size: 2rem;
      color: var(--gray);
      margin-bottom: 0;
    }
    .nav > .nav-btn > label > span {
      display: block;
      border-top: 2px solid var(--gray);
      height: 10px;
      width: 22px;
      transition: all 0.1s ease-in;
    }
    /* /Navbar Toggle */
    /* Navbar Items */
    .nav > .nav-items {
      position: absolute;
      display: block;
      width: 100%;
      background-color: var(--white);
      text-align: center;
      transition: all 0.3s ease-in;
      top: 70px; /* navbar height */
      left: 0px;
      z-index: 999 !important;
    }
    .nav > .nav-items > a,
    .nav > .nav-items > label {
      display: block;
      width: 99%;
      padding: 10px 0;
    }
    .nav > .nav-items > a.active,
    .nav-items > label.active {
      color: var(--gray);
      background-color: var(--lightwhite);
      border: 2px solid var(--grayborder);
      border-radius: 0;
    }
    /* /Navbar Items */
    /* Toggle State */
    .nav > #nav-check:not(:checked) ~ .nav-items {
      height: 0px;
    }
    .nav > #nav-check:not(:checked) ~ .nav-items a,
    .nav > #nav-check:not(:checked) ~ .nav-items label {
      display: none;
    }
    .nav > #nav-check:checked ~ .nav-btn > label > span:first-child {
      transform: translateX(-3.5px) translateY(6px) rotate(45deg);
    }
    .nav > #nav-check:checked ~ .nav-btn > label > span:nth-child(2) {
      display: none;
    }
    .nav > #nav-check:checked ~ .nav-btn > label > span:last-child {
      transform: translateX(3px) translateY(-6px) rotate(-45deg);
    }
    .nav > #nav-check:checked ~ .nav-items {
      height: calc(100vh - 70px);
      overflow-y: auto;
      z-index: 999 !important;
    }
    .nav > #nav-check:checked ~ .nav-items a,
    .nav > #nav-check:checked ~ .nav-items label {
      display: block;
    }
    /* /Toggle State */
    /* Dropdown */
    input#nav-dropdown ~ ul {
      position: static;
      margin: auto;
      padding: 0.5rem 1.5rem;
      background-color: var(--white);
      border: 1px solid #ddd;
    }
    /* /Dropdown */
  }  
`;

template.innerHTML = /*html*/`
<style>
    ${styles}
</style>
<header>
    <nav class="nav nav-box-shadow" id="nav">
        <input type="checkbox" id="nav-check">
        <div class="nav-header">
            <div class="nav-title">
                <img src="svg/icon.svg" class="navbar-brand-img" alt="Logo" />
            </div>
        </div>
        <div class="nav-btn">
            <label for="nav-check">
                <span></span>
                <span></span>
                <span></span>
            </label>
        </div>
        <div class="nav-items">
            <a id="navhome" href="#/">Home</a>
            <a id="navabout" href="#/about">About Us</a>
            <input type="checkbox" id="nav-dropdown">
        </div>
    </nav>
</header>
`;

export default class NavComponent extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({ mode: 'open' });
        this.shadowRoot.appendChild(template.content.cloneNode(true));
        this.assignElements();
        this.pageScroll = this.pageScroll.bind(this);
        window.onscroll = this.pageScroll;
    }

    connectedCallback() {

    }

    disconnectedCallback() {

    }

    assignElements() {
      this._locationElements = {
        "navhome": "#/",
        "navabout": "#/about"
      };
      this._lastScrollTop = 0;
    }

    changeActiveElement() {
      // 1. check current route
      const { hash } = window.location;
      // 2. Assign active to mapped element
      const that = this;
      const navitems = this.shadowRoot.querySelector(".nav-items").children;
      if(hash == "")
        this.shadowRoot.querySelector("#navhome").className = "active";
      else
        for(let navitem of navitems) {
          if(hash == that._locationElements[navitem.id])
            navitem.className = "active";
          else
            navitem.classList.remove("active");
        }
      this.shadowRoot.querySelector("#nav-check").checked = "";
    }

    pageScroll() {
      const navbar = this.shadowRoot.querySelector("nav");
      const scrollTop = window.pageYOffset || document.documentElement.scrollTop;
      if(scrollTop > this._lastScrollTop && scrollTop > 70)
          navbar.style.top = '-70px';
      else
          navbar.style.top = '0';
      this._lastScrollTop = scrollTop;
    }
}

window.customElements.define('app-navbar', NavComponent);