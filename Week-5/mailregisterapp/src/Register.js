import { useState } from "react";
import "./Register.css";

function Register() {
  const [form, setForm] = useState({
    name: "",
    email: "",
    password: ""
  });

  const [errors, setErrors] = useState({});

  // Handle input changes
  const handleChange = (e) => {
    const { name, value } = e.target;

    setForm({
      ...form,
      [name]: value
    });

    validateField(name, value);
  };

  // Validate individual field
  const validateField = (fieldName, value) => {
    let message = "";

    switch (fieldName) {
      case "name":
        if (value.length < 5)
          message = "Name must contain at least 5 characters";
        break;

      case "email":
        if (!(value.includes("@") && value.includes(".")))
          message = "Email must contain @ and .";
        break;

      case "password":
        if (value.length < 8)
          message = "Password must contain at least 8 characters";
        break;

      default:
        break;
    }

    setErrors((prev) => ({
      ...prev,
      [fieldName]: message
    }));
  };

  // Handle form submit
  const handleSubmit = (e) => {
    e.preventDefault();

    validateField("name", form.name);
    validateField("email", form.email);
    validateField("password", form.password);

    if (
      form.name.length >= 5 &&
      form.email.includes("@") &&
      form.email.includes(".") &&
      form.password.length >= 8
    ) {
      alert("Registration Successful!");
    } else {
      alert("Please correct the errors before submitting.");
    }
  };

  return (
    <div className="container">
      <form onSubmit={handleSubmit}>
        <h2>Mail Registration Form</h2>

        <label>Name</label>

        <input
          type="text"
          name="name"
          value={form.name}
          onChange={handleChange}
        />

        {errors.name && <p className="error">{errors.name}</p>}

        <label>Email</label>

        <input
          type="text"
          name="email"
          value={form.email}
          onChange={handleChange}
        />

        {errors.email && <p className="error">{errors.email}</p>}

        <label>Password</label>

        <input
          type="password"
          name="password"
          value={form.password}
          onChange={handleChange}
        />

        {errors.password && (
          <p className="error">{errors.password}</p>
        )}

        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default Register;