const BASE_URL = 'http://localhost:8080';

let currentPage = 0;

let searchField = document.getElementById('searchField')

let prevButton = document.getElementById('prevBtn');

let nextButton = document.getElementById('nextBtn');

function nextPage() {
    currentPage++;
    getCards(searchField.value);
}

function prevPage() {
    currentPage--;
    getCards(searchField.value);
}

getCards('\u0020');

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
    getCards(object['value']);
}

function getCards(value) {
    axios.get(BASE_URL + '/product/name?pattern=' + value + '&page=' + currentPage)
    .then(function (response) {
        console.log(response.data)
        let div = document.getElementById('card-row');
        div.innerHTML = ``;
        response.data.content.forEach(e=>{
            let card = document.createElement('div');
            card.innerHTML = `
                <div class="col">
                    <img src="images/${e.image}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title text-center">${e.name}</h5>
                    </div>
                </div>
            `;
            div.append(card);
        })
        console.log('doneeeee');
        
        // if(currentPage >= response.data.totalPages) {
        //     nextButton.style.display = 'none';
        // }
        // else if(currentPage <= 0){
        //     prevButton.style.display = 'none';
        // }
    })
    .catch(function (error) {
        console.log(error);
    });
}

prevButton.addEventListener('click', prevPage)
nextButton.addEventListener('click', nextPage)