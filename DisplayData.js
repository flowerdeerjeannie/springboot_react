import React, { useState, useEffect } from 'react';

const DataDisplay = () => {
     const [dataBoard, setDataBoard] = useState([]);

     const loadBoard = async () => {
          await fetch('http://localhost:8080/board')
               .then(resp => resp.json()) 
               .then(result =>setDataBoard(result))
               .catch(error =>console.log(error));
          }
     

     const loadData = () => {
          return (
               <table align="center">
                    <thead>
                         <tr>
                              <td>ID</td><td>title</td><td>writer</td>
                              <th>content</th><th>createDate</th>
                         </tr>                        
                    </thead>
                    <tbody>
                         {dataBoard.map(board=>(
                                   <tr key={board.id}>
                                        <td>{board.id}</td>
                                        <td>{board.title}</td>
                                        <td>{board.writer}</td>
                                        <td>{board.content}</td>
                                        <td>{board.createDate}</td>
                                   </tr>
                         ))}
                    </tbody>
               </table>
          );
     };

     return (
          <div>
               <h2>Data Display</h2>
               <button onClick={() => loadBoard()}>Board</button>
               <div>{loadData()}</div>
          </div>
     );
};

export default DataDisplay;