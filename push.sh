#!/bin/bash

# Function to push the repository to Git
push_repo() {
  echo "Pushing repository to Git..."
  git add .
  timestamp=$(date +'%m/%d/%Y/%H/%M/%S')
  commit_message="Automated commit - $timestamp"
  git commit -m "$commit_message"
  git push origin main

  # Save commit message to commits.json
  if [ ! -f commits.json ]; then
    echo "[" > commits.json
    first_commit=true
  else
    first_commit=false
  fi

  if [ "$first_commit" = false ]; then
    # Check if the file is empty
    if [ -s commits.json ]; then
      # Get the size of the file
      file_size=$(stat -c%s commits.json)
      # Subtract 1 to account for the last character
      end_pos=$((file_size - 1))
      # Use sed to insert the comma before the last character
      sed -i "${end_pos}i," commits.json
    fi
  fi
  echo "{ \"message\": \"$commit_message\" }" >> commits.json
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
      echo "]" >> commits.json
      exit 0
      ;;
    *)
      echo "Invalid choice. Please try again."
      ;;
  esac
done
