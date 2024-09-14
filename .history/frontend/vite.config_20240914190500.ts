import { defineConfig } from "vite";
import react from "@vitejs/plugin-react-swc";

// https://vitejs.dev/config/
export default defineConfig({
  server: {
    port: parseInt(process.env.API_PORT || "300"),
  },
  plugins: [react()],
});
