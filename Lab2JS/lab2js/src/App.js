import React, { Component } from 'react';
import './App.css';

class App extends Component {
  render() {
      return (
          <div className="body">
              <div className="app">
                  <div className="title">
                      <h1>Россіянинъ</h1><h2 className="title__page">Войти</h2>
                  </div>
                  <div className="login">
                      <div className="login__social">
                          <a className="putin" href="http://putin.kremlin.ru/"
                             title="Страница Императора Россійскаго"><i
                              className="fa fa-eye"></i></a>
                          <a className="nobility" href="http://www.nobility.ru/"
                             title="Страница Россійскаго Дворянскаго Собранія"><i className="fa fa-group"></i></a>
                          <a className="ispovednik" href="https://ispovednik.org/"
                             title="Россiская Православная Церковь"><i
                              className="fa fa-institution"></i></a>
                      </div>
                      <form className="login__normal">
                          <div className="login__field">
                              <label htmlFor="mail">Имя</label>
                              <input type="mail" id="mail" pattern="[A-Za-z]{3}"/>
                          </div>
                          <div className="login__field">
                              <label htmlFor="password">Секретъ</label>
                              <input type="password" id="password"/>
                          </div>
                          <button type="submit" className="login__submit">Пожаловать</button>
                      </form>
                  </div>
                  <div className="other">
                      <a className="link" href="./App2">Регистрація</a>
                  </div>
              </div>
          </div>
      );
  }

    validateName = name => {
        const regex = /[A-Za-z]{3,}/;

        return !regex.test(name)
            ? "The name must contain at least three letters. Numbers and special characters are not allowed."
            : "";
    };
}

export default App;
