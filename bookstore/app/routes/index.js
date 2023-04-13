import Route from '@ember/routing/route';
import { tracked } from '@glimmer/tracking';
import { A } from "@ember/array";
import Book from "../models/book"


export default class extends Route {
  
    model() {
        console.log("we are in the route")
        return fetch("/books")
            .then(res => res.json())
            .then(res => res.map(o => new Book(o)))
            .then(books => A(books));
        }
}