import Component from '@glimmer/component';
import { tracked } from '@glimmer/tracking';
import { action } from '@ember/object';

export default class BookComponent extends Component {


    @action
    deleteBook() {
        fetch("/books/"+this.args.book.id,{
            method:'DELETE',
            headers:{
                'Content-Type':'application/json'
            }
        }).then(res=> {
            console.log("Success", res);
            this.args.model.removeObject(this.args.book);
        })
        .catch(err => console.log(err))

    }
    @action
    updateBook(){
        console.log(this.args.book);
    }
}




