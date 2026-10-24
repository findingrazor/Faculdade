// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries
 
// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
export const enviroment = {
  production: true,
  firebase: {
    apiKey: "AIzaSyCb9iN0i0w4XQSstHRU84eGRz5Sqt583_A",
    authDomain: "apprestoq.firebaseapp.com",
    projectId: "apprestoq",
    storageBucket: "apprestoq.firebasestorage.app",
    messagingSenderId: "360217188042",
    appId: "1:360217188042:web:629116786e213999458633",
    measurementId: "G-46LVZGH7GX"
  }
};
// Initialize Firebase
const app = initializeApp(enviroment.firebase);
const analytics = getAnalytics(app);
