/**
 * Created by erpljq on 2018/6/8.
 */
function changeVarifyCode(img) {
    img.src = "../Kaptcha?" + Math.floor(Math.random() * 100);
}
