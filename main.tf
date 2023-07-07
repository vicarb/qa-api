provider "google" {
  project = "img-project-392101"
  region  = "us-west1"
}

resource "google_cloud_run_service" "default" {
  name     = "my-cloudrun-service"
  location = "us-west1"

  template {
    spec {
      containers {
        image = "us-west1-docker.pkg.dev/img-project-392101/west-repo/qa-app:v1"
      }
    }
  }

  traffic {
    percent         = 100
    latest_revision = true
  }
}


