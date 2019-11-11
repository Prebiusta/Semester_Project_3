import React, { Component } from 'react';

export class Projects extends Component {
  static displayName = Projects.name;

  constructor(props) {
    super(props);
    this.state = { projects: [], loading: true };
  }

  componentDidMount() {
      this.fetchProjectsData();
  }

  static renderProjectsTable(projects) {
    return (
      <table className='table table-striped' aria-labelledby="tabelLabel">
        <thead>
        <tr>
            <th>Project ID</th>
            <th>Name</th>
            <th>Number of Iterations</th>
            <th>Status</th>
            <th>Length Of Spring</th>
          </tr>
        </thead>
        <tbody>
          {projects.map(project =>
            <tr key={project.projectId}>
                <td>{project.projectId}</td>
                <td>{project.name}</td>
                <td>{project.status}</td>
                <td>{project.numberOfIterations}</td>
                <td>{project.lengthOfSprint}</td>
            </tr>
          )}
        </tbody>
      </table>
    );
  }

  render() {
    let contents = this.state.loading
      ? <p><em>Loading...</em></p>
      : Projects.renderProjectsTable(this.state.projects);

    return (
      <div>
        <h1 id="tabelLabel" >Projects</h1>
        <p>This component demonstrates fetching data from the server.</p>
        {contents}
      </div>
    );
  }

  async fetchProjectsData() {
    const response = await fetch('project');
    const data = await response.json();
    this.setState({ projects: data, loading: false });
  }
}
