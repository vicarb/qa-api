provider "google" {
  project = "terra-project-391200"
  region  = "us-central1"
}

resource "google_cloud_run_service" "default" {
  name     = "my-cloudrun-service"
  location = "us-central1"

  template {
    spec {
      containers {
        image = "webcl/qa-api:latest"
      }
    }
  }

  traffic {
    percent         = 100
    latest_revision = true
  }
}
