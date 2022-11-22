const BASE_URL = 'http://localhost:8080'

const searchForm = document.getElementById('search-form');

searchForm.addEventListener('submit', searchHandler);

function searchHandler(e){
    e.preventDefault();
    const form = e.target;
    const formData = new FormData(form);
    var object = {};
    formData.forEach(function(value, key){
        object[key] = value;
    });
    getCard(object);
}

let searchField = document.getElementById('searchField');

function getCard() {
    axios.get(BASE_URL + '/product/name/' + searchField.value)
    .then(function (response) {
        console.log(response.data)
        let div = document.getElementById('card-row');
        div.innerHTML = ``;
        response.data.forEach(e=>{
            let card = document.createElement('div');
            card.innerHTML = `
                <div class="col">
                    <div class="card" data-bs-toggle="modal" data-bs-target="#modal">
                        <img src="${e.image}" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title text-center">${e.name}</h5>
                        </div>
                    </div>
                </div>
            `;
            div.append(card);
        })
    })
    .catch(function (error) {
        console.log(error);
    });
}