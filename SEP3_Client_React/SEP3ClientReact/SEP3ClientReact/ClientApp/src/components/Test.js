import React, { Component } from 'react';
import * as utilities from './RESTClient.js';

export class Test extends Component {
    static displayName = Test.name;
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div class="form-group">
                    <label>
                        Username:
                        <input type="text" id="usernameInput" />
                    </label>
                </div>
                <div class="form-group">
                    <label>                  
                        Password:
                         <input type="text" id="passwordInput" />
                    </label>
                </div>
                <input type="submit" value="Submit" />
            </form>
        );
    }

    async authorize() {
        let user = '{ "username": "' + document.getElementById("usernameInput") +
                   '", "password": "' + document.getElementById("passwordInput") + '" }';
        let response = utilities.Post(user, "auth/login");
        if (response == true) {
            alert("Success");
        } else {
            alert("Fail");
        }
    }
}