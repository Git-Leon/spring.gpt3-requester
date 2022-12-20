class GptService {
    constructor(token) {
        this.token = token;
    }

    readFile(file) {
      return new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.onload = event => {
          resolve(event.target.result);
        };
        reader.onerror = error => {
          reject(error);
        };
        reader.readAsText(file);
      });
    }

    async promptRequestWithFile(files, e) {
      e.preventDefault();
      const extension = '.txt';

      for (const file of files) {
        if (path.extname(file.name) === extension) {
          const fileContents = await readFile(file);
          const token = document.getElementById("token").value;
          const requestObject = {
            token: token,
            prompt: fileContents
          };

          $.ajax({
            async: false,
            type: "POST",
            url: "/gpt/query-with-file",
            data: JSON.stringify(requestObject),
            contentType: "application/json",
            success: function(response) {
              console.log(response);
            }
          });
        }
      }
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