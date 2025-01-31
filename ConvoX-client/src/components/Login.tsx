import React, { ReactElement, useState } from "react";
import { IoCloseCircle } from "react-icons/io5";

interface Props{
    onClose: () => void
}
const Login = ({onClose}:Props) : ReactElement => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    // Handle login logic here
    console.log("Logging in with:", email, password);
  };

  return (
<div className="w-full max-w-sm p-8 space-y-6 bg-white rounded-xl shadow-lg border-2 border-gray-300 absolute left-0 right-0 mx-auto top-60">
    <IoCloseCircle className="text-red-400 text-right block ml-[95%] cursor-pointer text-[1.3em] hover:text-red-600 transition duration-300 ease-in-out" onClick={onClose}/>

        <h2 className="text-3xl font-semibold text-center text-gray-800">Login</h2>
        <form onSubmit={handleSubmit} className="space-y-6">
          {/* Email Input */}
          <div>
            <label htmlFor="email" className="block text-sm font-medium text-gray-600">
              Email
            </label>
            <input
              id="email"
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
              className="mt-2 block w-full px-4 py-2 text-sm text-gray-800 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-transparent transition duration-300"
              placeholder="Enter your email"
            />
          </div>

          {/* Password Input */}
          <div>
            <label htmlFor="password" className="block text-sm font-medium text-gray-600">
              Password
            </label>
            <input
              id="password"
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
              className="mt-2 block w-full px-4 py-2 text-sm text-gray-800 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-transparent transition duration-300"
              placeholder="Enter your password"
            />
          </div>

          {/* Submit Button */}
          <button
            type="submit"
            className="w-full py-2 px-4 text-white bg-indigo-600 rounded-lg shadow-md hover:bg-indigo-700 focus:ring-2 focus:ring-indigo-500 transition duration-300"
          >
            Login
          </button>
        </form>

        {/* Register Link */}
        <div className="text-center">
          <span className="text-sm text-gray-600">
            Don't have an account?{" "}
            <a href="#" className="text-indigo-600 hover:underline">
              Register
            </a>
          </span>
        </div>
      </div>
  );
};

export default Login;
