# Vendo-Matic 800 Vending Machine Software

Welcome to the Vendo-Matic 800, an advanced vending machine application developed for Umbrella Corp. This application allows users to interact with a virtual vending machine to purchase beverages, candy, chips, and gum directly from their computers. The application is designed using modern software design patterns, including Singleton, Factory, State, and DAO patterns to ensure scalability, maintainability, and robust functionality.

## Features

- **Product Dispensation**: Dispenses beverages, candy, chips, and gum with a real-time inventory update.
- **Dynamic User Interface**: Offers a main menu with options to display items, purchase products, or exit the application.
- **Automated Inventory Management**: Reads inventory from a file and restocks automatically at startup.
- **Transaction Logging**: Logs all transactions to prevent theft and discrepancies in a file named `Log.txt`.
- **Sales Reporting**: Includes a hidden feature to generate sales reports with unique file naming based on date and time.

## Installation

Before you can run the Vendo-Matic 800, make sure you have Java installed on your machine. Follow these steps to setup:

1. **Install Java**:
   - Visit [Java's download page](https://www.java.com/download/) and download the latest version of the JDK.
   - Follow the installation instructions for your specific operating system.

2. **Clone the Repository**:
   - Clone this repository to your local machine using `git clone [repository-url]`.

3. **Navigate to the Project Directory**:
   - Open your terminal.
   - Change directory to the project folder where you cloned the repository.

## Running the Application

To run the Vendo-Matic 800 application, follow these steps:

1. **Compile the Code**:
   - In your terminal, compile the Java files by running:
     ```
     javac VendingMachine.java
     ```
   - Ensure all dependencies are correctly compiled.

2. **Execute the Program**:
   - Run the application by executing:
     ```
     java VendingMachine
     ```
   - The main menu will appear, and you can start interacting with the vending machine.

## Usage

- **Main Menu**: Use the number keys to navigate the menu options.
- **Purchase Flow**: Follow the on-screen prompts to feed money, select products, and finalize your transaction.

## Contributions

Contributions are welcome. Please fork this repository and submit pull requests with any enhancements.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
