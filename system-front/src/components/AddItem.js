import React, { useEffect, useState } from "react";
import ItemService from '../services/ItemService';

const AddItem = () => {

    const [item, setItem] = useState({
        id:'',
        name:'',
        description:'',
    });

    const handleChange = (e) => {
        const value = e.target.value;
        setItem({...item, [e.target.name]: value});
    };

    const saveItem = (e) => {
        e.preventDefault();
        if (1 == 1) {
        ItemService.saveItem(item).then((response) => {
            console.log(response);
            console.log(item.description.length);
        })
        .catch((error) => {
            console.log(error);
        })} else {alert('Please Fill All Required Fields')}
        const value = e.target.value;

    }

  return (
    <div className='flex max-w-2xl mx-auto shadow border-b'>
        <div className='px-8 py-8'>
            <div className='font-thin text-2xl tracking-wider'>
                <h1>Add New Item</h1>
            </div>
            <div className='items-center justify-center h-14 w-full my-4'>
                <label class='block text-gray-600 text-sm font-normal'>Name</label>
                <input 
                    type='text' 
                    name='name' 
                    value={item.name}
                    onChange={(e) => handleChange(e)}  
                    className='h-10 w-96 mt-2 px-2 py-2 border shadow'></input>
            </div>
            <div className='items-center justify-center h-14 w-full my-4'>
                <label class='block text-gray-600 text-sm font-normal'>Description</label>
                <input 
                    type='text' 
                    name='description' 
                    value={item.description}  
                    onChange={(e) => handleChange(e)} 
                    className='h-10 w-96 mt-2 px-2 py-2 border shadow'></input>
            </div>

            <div className='items-center justify-center h-14 w-full my-4 space-x-4 pt-4'>
                <button onClick={saveItem} className='rounded text-white font-semibold bg-green-400 py-2 px-2 hover:bg-green-700'>
                    Save
                </button>
                <button className='rounded text-white font-semibold bg-red-400 py-2 px-2 hover:bg-red-700'>
                    Clear
                </button>
            </div>
        </div>    
    </div>
  );
};

export default AddItem;