import fetch from 'unfetch';

const checkStatus = response => {
    if (response.ok) {
        return response;
    } else {
        let error = new Error(response.statusText);
        error.response = response;
        response.json().then(e => {
            error.error = e;
        });

        // returns a reject with the error itself
        return Promise.reject(error);
    }
}

// We proxy the localhost 

export const getAllStudents = () => 
        fetch('http://localhost:8080/api/students')
        .then(checkStatus);

export const addNewStudent = student => 
        fetch('api/students', {
            // headers: content-type
            headers: {
                'Content-Type':'application/json'
            },
            method: 'POST',
            body: JSON.stringify(student)
        })
        .then(checkStatus);