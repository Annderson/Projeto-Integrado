using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Projeto_Integrado_A_
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            if (!Directory.Exists("C:\\temp"))
            {
                Directory.CreateDirectory("C:\\temp");
            }

            if (!File.Exists("C:\\temp\\PREMIOS.TXT"))
            {
                StreamWriter outStream = File.CreateText("C:\\temp\\PREMIOS.TXT");
                outStream.Write(Properties.Resources.PREMIOS);
                outStream.Close();
            }

            if (!File.Exists("C:\\temp\\RESULTADOS.TXT"))
            {
                StreamWriter outStream = File.CreateText("C:\\temp\\RESULTADOS.TXT");
                outStream.Write(Properties.Resources.RESULTADOS);
                outStream.Close();
            }

            Application.Run(new Projeto_Integrado_A_v2());
        }
    }
}
