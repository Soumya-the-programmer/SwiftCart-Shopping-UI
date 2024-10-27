# SwiftCart

## Overview

SwiftCart is a simple Android application that showcases a shopping interface, allowing users to browse various clothing items. Each item displays its image, name, price, and description, providing a user-friendly shopping experience.

## ScreenShots

<p float="left">
  <img src="https://github.com/user-attachments/assets/dd211c3c-9e87-4809-a56b-43013c33f693" width="30%" />
  <img src="https://github.com/user-attachments/assets/80dae907-6a26-43db-89f2-5d15db3fec75" width="30%" />
  <img src="https://github.com/user-attachments/assets/47eb230f-d912-4154-b942-5ce292a00f5e" width="30%" />
  <img src="https://github.com/user-attachments/assets/245b6e61-cd73-4397-8f14-6576b6079cfb" width="30%" />
  <img src="https://github.com/user-attachments/assets/962d3d21-852f-4a7a-aedc-980f372a2452" width="30%" />
  <img src="https://github.com/user-attachments/assets/8084c21e-0edf-41c2-8246-5aab2c9076ff" width="30%" />
</p>

## Features

- Grid display of clothing items with images, names, and prices.
- Clickable items that reveal detailed product information.
- Dynamic user interface designed using Jetpack Compose.
- Sample data for clothing items sourced from a static class.

## Technologies Used

- **Kotlin**
- **Jetpack Compose**
- **Android Studio**

## Dependencies

To run this project, ensure you include the following dependencies in your `build.gradle` file:

```groovy
dependencies {
    implementation "androidx.compose.ui:ui:1.0.0"        // Jetpack Compose UI
    implementation "androidx.compose.material:material:1.0.0" // Material Design components
    implementation "androidx.compose.ui:ui-tooling-preview:1.0.0" // UI preview
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1" // Lifecycle components
    implementation "androidx.activity:activity-compose:1.3.1" // Activity for Compose
    // Add other dependencies as needed
}
```

## Getting Started

### Prerequisites

- Android Studio installed on your machine.
- Basic understanding of Kotlin and Jetpack Compose.

### Installation

1. Clone the repository:
   ```bash
   git clone <(https://github.com/Soumya-the-programmer/SwiftCart-Shopping-UI/tree/main)>
    ```
2. Open the project in Android Studio.
3. Ensure all dependencies are included in your build.gradle file.
4. Wait for the Gradle build to finish.
5. Run the app on an emulator or a physical device.

### Usage

- Launch the application.
- Browse through the list of clothing items.
- Click on an item to view its details.
