#!/bin/bash

# Function to push the repository to Git
push_repo() {
  echo "Pushing repository to Git..."
  git add .
  timestamp=$(date +'%m/%d/%Y/%H/%M/%S')
  git commit -m "$timestamp"
  git push origin main
  echo "Repository pushed successfully."
}

# Function to rollback the last commit
rollback() {
  echo "Rolling back the last commit..."
  git reset --soft HEAD^
  echo "Last commit rolled back.  Changes are staged."
}

# Display the menu
show_menu() {
  echo "----------------------------"
  echo "Git Operations Menu"
  echo "----------------------------"
  echo "1. Push Repository to Git"
  echo "2. Rollback Last Commit"
  echo "3. Exit"
  echo "----------------------------"
  echo -n "Enter your choice: "
}

# Main script logic
while true; do
  show_menu
  read choice

  case $choice in
    1)
      push_repo
      ;;
    2)
      rollback
      ;;
    3)
      echo "Exiting..."
      clear
      exit 0
      ;;
    *)
      echo "Invalid choice. Please try again."
      ;;
  esac
done
