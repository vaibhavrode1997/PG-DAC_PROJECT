
import './App.css';
import 'bootstrap/dist/css/bootstrap.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './pages/Home'
import About from './pages/About'
import Login from './pages/Login'
import Register from './pages/Register'
import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer } from 'react-toastify';
import PrivateRoutes from './Componants/PrivateRoutes';
import Profileinfo from './pages/User_Routes/Profileinfo';
import Contactus from './pages/Contactus';
import Admin from './Admin/admin';
import User from './User/user';
import Vendor from './Vendor/vendor';
import Wedding from './User/Wedding/Wedding';
import Birthday from './User/Birthday/Birthday';
import Party from './User/Party/Party';
import Concert from "./User/Concert/Concert";
import Business from './User/Business/Business';
import Festival from './User/Festival/Festival';
import Exhibition from './User/Exhibition/Exhibition';
import Convention from './User/Convention/Convention';
import Seminar from "./User/Seminar/Seminar";
import FamilyFunction from './User/FamilyFunction/FamilyFunction';
import HybridEvent from './User/HybridEvent/HybridEvent';
import Base from './Componants/Base';
import ServicesPage from './pages/Services';

import Caterer1 from './User/userUI/Caterer1'
import Decoration1 from './User/userUI/Decoration1'
import Book from './User/userUI/Book'
import Firecrackers1 from './User/userUI/Firecrackers1'
import Flower1 from './User/userUI/Flower1'
import Horse1 from './User/userUI/Horse1'
import Hall1 from './User/userUI/Hall1'
import Light1 from './User/userUI/Light1'
import Makeup1 from './User/userUI/Makeup1'
import MusicSystem1 from './User/userUI/MusicSystem1'
import Poojavidhi1 from './User/userUI/Poojavidhi1'
import Photography1 from './User/userUI/Photography1'
import Transportation1 from './User/userUI/Transportation1'
import WaterSupply1 from './User/userUI/WaterSupply1'
import Vieworder from './User/userUI/Vieworder'


import Hall from './Vendor/Hall';
import Caterer from './Vendor/Caterer';
import Decoration from './Vendor/Decoration';
import Firecrackers from './Vendor/Firecrackers'
import Flower from './Vendor/Flower'
import Horse from './Vendor/Horse'
import Light from './Vendor/Light'
import Makeup from './Vendor/Makeup'
import MusicSystem from './Vendor/MusicSystem'
import Photography from './Vendor/Photography'
import Poojavidhi from './Vendor/Poojavidhi'
import WaterSupply from './Vendor/WaterSupply'
import Transportation from './Vendor/Transportation'
import { ForgotPassword } from './pages/ForgotPassword';


export default function App() {
  return (
    < BrowserRouter>
      <Base></Base>
      <ToastContainer position='bottom-center' />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About></About>} />
        <Route path="/login" element={<Login></Login>} />
        <Route path="/register" element={<Register></Register>} />
        <Route path="/contactus" element={<Contactus></Contactus>} />
        <Route path="/services" element={<ServicesPage></ServicesPage>} />


        <Route path="/users" element={<PrivateRoutes></PrivateRoutes>} >
          <Route path="profileinfo" element={<Profileinfo></Profileinfo>} />

          {/* for user role wise dispatching */}
          <Route path="admin" element={<Admin></Admin>} />
          <Route path="user" element={<User></User>} />
          <Route path="vendor" element={<Vendor></Vendor>} />
        </Route>

        {/* //it is for user */}
        <Route path="Wedding" element={<Wedding></Wedding>} />
        <Route path="Birthday" element={<Birthday></Birthday>} />
        <Route path="Party" element={<Party></Party>} />
        <Route path="Concert" element={<Concert></Concert>} />
        <Route path="Business" element={<Business></Business>} />
        <Route path="Festival" element={<Festival></Festival>} />
        <Route path="Exhibition" element={<Exhibition></Exhibition>} />
        <Route path="Convention" element={<Convention></Convention>} />
        <Route path="Seminar" element={<Seminar></Seminar>} />
        <Route path="FamilyFunction" element={<FamilyFunction></FamilyFunction>} />
        <Route path="HybridEvent" element={<HybridEvent></HybridEvent>} />

        {/* it is for vendor  */}
        <Route path="/Caterer" element={<Caterer></Caterer>} />
        <Route path="/Decoration" element={<Decoration></Decoration>} />
        <Route path="/Firecrackers" element={<Firecrackers></Firecrackers>} />
        <Route path="/Flower" element={<Flower></Flower>} />
        <Route path="/Horse" element={<Horse></Horse>} />
        <Route path="/Hall" element={<Hall></Hall>} />
        <Route path="/Light" element={<Light></Light>} />
        <Route path="/Makeup" element={<Makeup></Makeup>} />
        <Route path="/MusicSystem" element={<MusicSystem></MusicSystem>} />
        <Route path="/Photography" element={<Photography></Photography>} />
        <Route path="/Poojavidhi" element={<Poojavidhi></Poojavidhi>} />
        <Route path="/WaterSupply" element={<WaterSupply></WaterSupply>} />
        <Route path="/Transportation" element={<Transportation></Transportation>} />
      {/* it is for forgot password */}
      <Route path="/forgot-Password" element={<ForgotPassword></ForgotPassword>} />


       {/* it is for user ui display services*/}
       <Route path="/catererui" element={<Caterer1></Caterer1>} />
        <Route path="/decorationui" element={<Decoration1></Decoration1>} />
        <Route path="/firecrackersui" element={<Firecrackers1></Firecrackers1>} />
        <Route path="/flowerui" element={<Flower1></Flower1>} />
        <Route path="/horseui" element={<Horse1></Horse1>} />
        <Route path="/hallui" element={<Hall1></Hall1>} />
        <Route path="/lightui" element={<Light1></Light1>} />
        <Route path="/makeupui" element={<Makeup1></Makeup1>} />
        <Route path="/musicSystemui" element={<MusicSystem1></MusicSystem1>} />
        <Route path="/photographyui" element={<Photography1></Photography1>} />
        <Route path="/poojavidhiui" element={<Poojavidhi1></Poojavidhi1>} />
        <Route path="/waterSupplyui" element={<WaterSupply1></WaterSupply1>} />
        <Route path="/transportationui" element={<Transportation1></Transportation1>} />
        <Route path="/bookservice/:id/:servicetype" element={<Book></Book>} />
        <Route path="/vieworder/:id1" element={<Vieworder></Vieworder>} />
      </Routes>
    </BrowserRouter>
  );
}

