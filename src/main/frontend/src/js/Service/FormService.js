export default class FormService {
    constructor() { }

    buildHeaders(authorization = null) {
        const headers = {
            "Content-Type": "application/json",
            "Authorization": (authorization) ? authorization : "Bearer ",
        };
        return headers;
    }

    buildJsonFormData(form) {
        const jsonFormData = { };
        for(const pair of new FormData(form)) {
            jsonFormData[pair[0]] = pair[1];
        }
        return jsonFormData;
    }
}