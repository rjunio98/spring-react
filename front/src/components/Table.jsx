const Table = ({ vetor, selecionar }) => {
  return (
    <div>
      <table className="table">
        <thead>
          <tr>
            <th>#</th>
            <th>Nome</th>
            <th>Marca</th>
            <th>Selecionar</th>
          </tr>
        </thead>

        <tbody>
          {vetor.map((obj, indice) => (
            <tr key={indice}>
              <td>{obj.id}</td>
              <td>{obj.nome}</td>
              <td>{obj.marca}</td>
              <td>
                <button
                  className="btn btn-success"
                  onClick={() => {
                    selecionar(indice);
                  }}
                >
                  Selecionar
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Table;
