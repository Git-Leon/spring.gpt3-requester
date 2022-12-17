function request(e) {
    const token = document.getElementById("token").value;
    const prompt = document.getElementById("prompt").value;
    const result = new GptService(token).promptRequest(prompt,e);
    alert(result);
    return result;
}