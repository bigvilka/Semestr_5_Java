import React, { Component } from 'react';
import './App.css';

class App extends Component {
  render() {
    return (
        <div className="body">
            <div className="app">
                <div className="title">
                    <h1>Россіянинъ</h1><h2 className="title__page">Регистрація</h2>
                </div>
                <div className="login">
                    <form className="login__normal">
                        <div className="login__field">
                            <label htmlFor="email">Почта</label>
                            <input type="email" id="email" title="Нужен корректный адрес почты"/>
                        </div>
                        <div className="login__field">
                            <label htmlFor="mail">Имя</label>
                            <input type="mail" id="mail" pattern="^[А-Яа-яЁё]+$" title="Имя на русском"/>
                        </div>
                        <div className="login__field">
                            <label htmlFor="password">Секретъ</label>
                            <input type="password" id="password" pattern=".{6,}$" title="Пароль не менее 6 символов"/>
                        </div>
                        <div className="login__field">
                            <label htmlFor="password">Ещё разъ секретъ</label>
                            <input type="confirmPassword" id="password" pattern=".{6,}$" title="Пароль не менее 6 символов"/>
                        </div>
                        <button type="submit" className="login__submit">Пожаловать</button>
                    </form>
                </div>
                <div className="other">
                    <a className="link" href="#">Войти</a>
                </div>
            </div>
        </div>
    );
  }
}

export default App;
