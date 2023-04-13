import Component from '@glimmer/component';
import { tracked } from '@glimmer/tracking';
import { action } from '@ember/object';
import Book from '../models/book'

export default class BookComponent extends Component {
    // @tracked title;
    // @tracked isbn;
    // @tracked publishedDate;
    // @tracked firstName;
    // @tracked lastName;
    // @tracked dob;

    @action
    setBook() {
        if (this.args.model.id > 0) {
            this.updateBook();
        } else {
            this.addBook();
        }

    }

    addBook() {
        const bookObj = {
            title: this.args.model.title,
            isbn: this.args.model.isbn,
            publishedDate: this.args.model.publishedDate,
            authorList: [{
                firstName: this.args.model.authorList[0].firstName,
                lastName: this.args.model.authorList[0].lastName,
                doB: this.args.model.authorList[0].doB
            }
            ],
        }
        fetch("/books/", {
            method: 'POST',
            body: JSON.stringify(bookObj),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(res => res.json())
        .then(res => {
            console.log("Success", res);
            // this.args.model.addObject(bookObj)
            this.args.model.id = res.id
            return new Book(res)

        })
        .catch(err => console.log(err))
    }

    updateBook() {
        const paramId = this.args.model.id;
        const bookObj = {
            id: paramId,
            title: this.args.model.title,
            isbn: this.args.model.isbn,
            publishedDate: this.args.model.publishedDate,
            authorList: [{
                firstName: this.args.model.authorList[0].firstName,
                lastName: this.args.model.authorList[0].lastName,
                doB: this.args.model.authorList[0].doB
            }
            ],
        }
        console.log(bookObj);
        fetch("/books/" + paramId, {
            method: 'PUT',
            body: JSON.stringify(bookObj),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(res => {
            console.log("Success", res);
        })
            .catch(err => console.log(err))

    }

    clear() {
        this.args.model.title = null;
        this.args.model.isbn = null;
        this.args.model.publishedDate = null;
        this.args.model.authorList[0].firstName = null;
        this.args.model.authorList[0].lastName = null;
        this.args.model.authorList[0].doB = null;
    }

}


