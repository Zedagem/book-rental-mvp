import Route from '@ember/routing/route'
import Book from "../models/book"

export default class BookRoute extends Route{
    model(params){
        if(params.book_id > 0){
            return fetch("/books/"+params.book_id)
            .then(res => res.json())
            .then(data => new Book(data))
            .catch(err => console.log(err))
        } 
        return new Book();
    }

}