import { tracked } from '@glimmer/tracking';

export default class Book {
    @tracked id;
    @tracked title;
    @tracked isbn;
    @tracked publishedDate;
    @tracked authorList;

    constructor(o = {
        id: 0,
        title: '',
        isbn: '',
        publishedDate: new Date(),
        authorList: [{
            firstName: '',
            lastName: '',
            doB: ''
        }
        ]
    }) {
        this.id = o.id;
        this.title = o.title;
        this.isbn = o.isbn;
        this.publishedDate = o.publishedDate;
        this.authorList = o.authorList;
    }

}