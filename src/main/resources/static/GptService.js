class GptService {
    constructor(token) {
        this.token = token;
    }

    promptRequest(prompt, e) {
        e.preventDefault();
        let result;
        const request = {"token":this.token, "prompt":prompt};
        const jsonData = JSON.stringify(request);
        console.log(jsonData)

        $.ajax({
            type: "POST",
            crossDomain: true,
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            },
            url: "/gpt/query/",
            data: jsonData,
            dataType: "JSON ",
            success: function (response) {
                result = JSON.stringify(response)
            },
            error: function () {
                alert('Error while request..');
            },
            async: false
        });
        return result;
    }
}