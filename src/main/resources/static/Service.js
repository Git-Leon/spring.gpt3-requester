function request(e) {
    const token = document.getElementById("token").value;
    const prompt = document.getElementById("prompt").value;
    const result = new GptService(token).promptRequest(prompt,e);
    alert(result);
    return result;
}

function requestWithFile(e) {
    const token = document.getElementById("token").value;
    const prompt = document.getElementById("fileInput").files;
    const result = new GptService(token).promptRequestWithFile(prompt,e);
    alert(result);
    return result;
}