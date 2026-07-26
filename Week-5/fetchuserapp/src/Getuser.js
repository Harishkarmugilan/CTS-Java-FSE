import React, { Component } from "react";
import "./Getuser.css";

class Getuser extends Component {
  constructor(props) {
    super(props);

    this.state = {
      user: null,
      loading: true
    };
  }

  async componentDidMount() {
    try {
      const response = await fetch("https://api.randomuser.me/");
      const data = await response.json();

      this.setState({
        user: data.results[0],
        loading: false
      });
    } catch (error) {
      console.log(error);

      this.setState({
        loading: false
      });
    }
  }

  render() {
    const { user, loading } = this.state;

    if (loading) {
      return <h2>Loading...</h2>;
    }

    return (
      <div className="container">
        <h1>Random User Details</h1>

        <img
          src={user.picture.large}
          alt="User"
        />

        <h2>
          {user.name.title} {user.name.first}
        </h2>
      </div>
    );
  }
}

export default Getuser;