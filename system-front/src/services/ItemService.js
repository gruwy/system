import axios from 'axios';

const ITEM_API_BASE_URL = 'http://localhost:8080/api/item'

class ItemService {
    saveItem(item) {
        return axios.post(ITEM_API_BASE_URL, item);
    }
}

export default new ItemService();