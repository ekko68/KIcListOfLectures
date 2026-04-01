function validateEncryptedForm() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if (!username || !password) {
        alert("ID/비밀번호를 입력해주세요.");
        return false;
    }

    try {
        var rsaPublicKeyModulus = document.getElementById("rsaPublicKeyModulus").value;
        var rsaPublicKeyExponent = document.getElementById("rsaPublicKeyExponent").value;
        submitEncryptedForm(username,password, rsaPublicKeyModulus, rsaPublicKeyExponent);
    } catch(err) {
        alert(err);
    }
    return false;
}

function submitEncryptedForm(username, password, rsaPublicKeyModulus, rsaPpublicKeyExponent) {
   
}